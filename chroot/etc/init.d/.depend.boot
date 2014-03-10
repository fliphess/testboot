TARGETS = mountkernfs.sh udev mountdevsubfs.sh resolvconf mountall.sh mountall-bootclean.sh networking mountnfs.sh mountnfs-bootclean.sh hwclock.sh urandom mdadm-raid hostname.sh checkfs.sh checkroot.sh bootlogd procps lvm2 screen-cleanup stop-bootlogd-single bootmisc.sh kmod mtab.sh checkroot-bootclean.sh udev-mtab
INTERACTIVE = udev checkfs.sh checkroot.sh
udev: mountkernfs.sh
mountdevsubfs.sh: mountkernfs.sh udev
resolvconf: mountall.sh mountall-bootclean.sh
mountall.sh: mdadm-raid checkfs.sh checkroot-bootclean.sh lvm2
mountall-bootclean.sh: mountall.sh
networking: resolvconf mountkernfs.sh mountall.sh mountall-bootclean.sh urandom
mountnfs.sh: mountall.sh mountall-bootclean.sh networking
mountnfs-bootclean.sh: mountall.sh mountall-bootclean.sh mountnfs.sh
hwclock.sh: mountdevsubfs.sh bootlogd
urandom: mountall.sh mountall-bootclean.sh hwclock.sh
mdadm-raid: mountkernfs.sh hostname.sh udev
hostname.sh: bootlogd
checkfs.sh: mdadm-raid checkroot.sh mtab.sh lvm2
checkroot.sh: hwclock.sh mountdevsubfs.sh hostname.sh bootlogd
bootlogd: mountdevsubfs.sh
procps: bootlogd mountkernfs.sh mountall.sh mountall-bootclean.sh udev
lvm2: bootlogd mountdevsubfs.sh udev mdadm-raid
screen-cleanup: mountall.sh mountall-bootclean.sh mountnfs.sh mountnfs-bootclean.sh
stop-bootlogd-single: mountall.sh mountall-bootclean.sh udev resolvconf networking mountnfs.sh mountnfs-bootclean.sh hwclock.sh mountkernfs.sh urandom mdadm-raid hostname.sh checkfs.sh mountdevsubfs.sh checkroot.sh bootlogd procps lvm2 screen-cleanup bootmisc.sh kmod mtab.sh checkroot-bootclean.sh udev-mtab
bootmisc.sh: mountnfs-bootclean.sh checkroot-bootclean.sh mountall.sh mountall-bootclean.sh mountnfs.sh udev
kmod: checkroot.sh
mtab.sh: checkroot.sh
checkroot-bootclean.sh: checkroot.sh
udev-mtab: udev mountall.sh mountall-bootclean.sh
