#!/usr/bin/python
# Filename: RSADemo.py

def candp(a, b, c):
	r = 1
	b = b + 1
	while  b != 1:
		r = r * a;
		r = r % c
		b - 1
	printf(r)
	return r
