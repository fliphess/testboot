TARGETS = mountkernfs.sh udev mountdevsubfs.sh networking mountall.sh mountall-bootclean.sh mountnfs.sh mountnfs-bootclean.sh hwclock.sh urandom mdadm-raid hostname.sh checkfs.sh checkroot.sh bootlogd procps lvm2 bootmisc.sh udev-mtab kmod checkroot-bootclean.sh mtab.sh screen-cleanup stop-bootlogd-single
INTERACTIVE = udev checkfs.sh checkroot.sh
udev: mountkernfs.sh
mountdevsubfs.sh: mountkernfs.sh udev
networking: mountkernfs.sh mountall.sh mountall-bootclean.sh urandom
mountall.sh: mdadm-raid checkfs.sh checkroot-bootclean.sh lvm2
mountall-bootclean.sh: mountall.sh
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
bootmisc.sh: mountnfs-bootclean.sh mountall.sh mountall-bootclean.sh mountnfs.sh udev checkroot-bootclean.sh
udev-mtab: udev mountall.sh mountall-bootclean.sh
kmod: checkroot.sh
checkroot-bootclean.sh: checkroot.sh
mtab.sh: checkroot.sh
screen-cleanup: mountall.sh mountall-bootclean.sh mountnfs.sh mountnfs-bootclean.sh
stop-bootlogd-single: mountall.sh mountall-bootclean.sh udev networking mountnfs.sh mountnfs-bootclean.sh hwclock.sh mountkernfs.sh urandom mdadm-raid hostname.sh checkfs.sh mountdevsubfs.sh checkroot.sh bootlogd procps lvm2 bootmisc.sh udev-mtab kmod checkroot-bootclean.sh mtab.sh screen-cleanup
