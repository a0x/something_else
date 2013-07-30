#!/usr/bin/env sh

prefix=/usr/local
sudo rm ${prefix}/bin/erb
sudo rm ${prefix}/bin/gem
sudo rm ${prefix}/bin/irb
sudo rm ${prefix}/bin/rake
sudo rm ${prefix}/bin/rdoc
sudo rm ${prefix}/bin/ri
sudo rm ${prefix}/bin/ruby
sudo rm ${prefix}/bin/testrb

sudo rm -rf ${prefix}/include/ruby-*
sudo rm -rf ${prefix}/lib/ruby
sudo rm -rf ${prefix}/lib/pkgconfig
sudo rm ${prefix}/lib/libruby-static.a

sudo rm -rf ${prefix}/share/doc/ruby
sudo rm -rf ${prefix}/share/ri
sudo rm ${prefix}/share/man/man1/erb.1
sudo rm ${prefix}/share/man/man1/irb.1
sudo rm ${prefix}/share/man/man1/rake.1
sudo rm ${prefix}/share/man/man1/ri.1
sudo rm ${prefix}/share/man/man1/ruby.1
