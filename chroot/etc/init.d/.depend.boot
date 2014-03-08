TARGETS = mountkernfs.sh hostname.sh udev mountdevsubfs.sh networking mountall.sh mountall-bootclean.sh urandom mountnfs.sh mountnfs-bootclean.sh hwclock.sh checkroot.sh kmod bootmisc.sh procps checkfs.sh mtab.sh checkroot-bootclean.sh udev-mtab
INTERACTIVE = udev checkroot.sh checkfs.sh
udev: mountkernfs.sh
mountdevsubfs.sh: mountkernfs.sh udev
networking: mountkernfs.sh mountall.sh mountall-bootclean.sh urandom
mountall.sh: checkfs.sh checkroot-bootclean.sh
mountall-bootclean.sh: mountall.sh
urandom: mountall.sh mountall-bootclean.sh hwclock.sh
mountnfs.sh: mountall.sh mountall-bootclean.sh networking
mountnfs-bootclean.sh: mountall.sh mountall-bootclean.sh mountnfs.sh
hwclock.sh: mountdevsubfs.sh
checkroot.sh: hwclock.sh mountdevsubfs.sh hostname.sh
kmod: checkroot.sh
bootmisc.sh: mountnfs-bootclean.sh mountall.sh mountall-bootclean.sh mountnfs.sh udev checkroot-bootclean.sh
procps: mountkernfs.sh mountall.sh mountall-bootclean.sh udev
checkfs.sh: checkroot.sh mtab.sh
mtab.sh: checkroot.sh
checkroot-bootclean.sh: checkroot.sh
udev-mtab: udev mountall.sh mountall-bootclean.sh
