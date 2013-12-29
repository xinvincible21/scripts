#!/usr/bin/env python

import subprocess

def run_bash(cmd):
	process = subprocess.Popen(cmd.split(), stdout=subprocess.PIPE)
	return (process.communicate()[0], process.stderr, process.returncode)


def main():
	bashCommand = "ps waux"
	(out, err, exit) = run_bash(bashCommand) 
	print "out -> "
	print out
	print "err -> "
	print err
	print "exit -> "
	print exit

if __name__=='__main__':
	main()
