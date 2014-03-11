
This is a debian wheezy chroot for amd64. 
It uses a live boot, and doesn't need any disk or other harddrives to function. 

You can use either tftp and dhcp or create an iso file with the build scripts attached. 

By editting the binary/isolinux/isolinux.cfg or the pxelinux.cfg you can setup a medium to boot this chroot. 

The additional scripts are there to fastly create a filesystem in squash fs and an initrd. 
The oprating system is small and handy to use in test environments and development, but not only bound 
to virtual machines.

I use the fetch parameter of the debian live distro, to download a minimalized squash fs. 
This can be done through ftp, tftp and http. 

To install:

```
cd scripts 
./install.sh 

vim binary/isolinux/isolinux.cfg

```
