require '_h2ph_pre.ph';

no warnings qw(redefine misc);

if(defined(&_LIBC)) {
    die("Applications\ may\ not\ define\ the\ macro\ _LIBC");
}
unless(defined(&__stub_bdflush)) {
    sub __stub_bdflush () {	1;}
}
unless(defined(&__stub_chflags)) {
    sub __stub_chflags () {	1;}
}
unless(defined(&__stub_fattach)) {
    sub __stub_fattach () {	1;}
}
unless(defined(&__stub_fchflags)) {
    sub __stub_fchflags () {	1;}
}
unless(defined(&__stub_fdetach)) {
    sub __stub_fdetach () {	1;}
}
unless(defined(&__stub_getmsg)) {
    sub __stub_getmsg () {	1;}
}
unless(defined(&__stub_gtty)) {
    sub __stub_gtty () {	1;}
}
unless(defined(&__stub_lchmod)) {
    sub __stub_lchmod () {	1;}
}
unless(defined(&__stub_putmsg)) {
    sub __stub_putmsg () {	1;}
}
unless(defined(&__stub_revoke)) {
    sub __stub_revoke () {	1;}
}
unless(defined(&__stub_setlogin)) {
    sub __stub_setlogin () {	1;}
}
unless(defined(&__stub_sigreturn)) {
    sub __stub_sigreturn () {	1;}
}
unless(defined(&__stub_sstk)) {
    sub __stub_sstk () {	1;}
}
unless(defined(&__stub_stty)) {
    sub __stub_stty () {	1;}
}
1;
