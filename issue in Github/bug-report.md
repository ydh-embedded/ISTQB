Windows Terminal version
67ae9f6

Windows build number
No response

Other Software
No response

Steps to reproduce
When a command that is the same length as the window is run, it causes the cursor to jump to the next line 2 characters into typing the next command.

When the final character is input the cursor moves back one char instead of to the next line.
It seems to vary by font size. I was able to reproduce the issue with font size 10 and 12 but not 11
Commenting out these 4 line seemed to fix the issue.

I tried to understand the unit tests mentioned in the ticket from the comments GH#15602 and tried to reproduce them in vim but was not successful
terminal/src/terminal/adapter/adaptDispatch.cpp

Lines 144 to 149 in 67ae9f6

 // TODO: A row should not be marked as wrapped just because we wrote the last column. 
 // It should be marked whenever we write _past_ it (above, _DoLineFeed call). See GH#15602. 
 if (wrapAtEOL && state.columnEnd >= state.columnLimit) 
 { 
     textBuffer.SetWrapForced(cursorPosition.y, true); 
 } 
Expected Behavior
The cursor not to jump to the next line while typing the next command.

Actual Behavior
The cursor jumped to the next line while typing the next command