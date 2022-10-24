# Name: Jonathan Santos
# CIN: 304669604

import tkinter
from tkinter import *
import tkinter.messagebox


# This function finds if the given credit card number is greater than 13 and less than 16 values.
def size(number):
    str_number = str(number)
    if 13 <= len(str_number) <= 16:
        return True
    else:
        return False


def sum_of_double_even(number):
    str_number = str(number)
    double_list = 0
    # Reverses the credit card number and puts all the second digit from left to right in the list into a new variable.
    # Then the new variable is converted into a list and sent to a new list variable.
    temp_number = str_number[::-1]
    new_number = temp_number[1::2]
    new_list = list(new_number.strip())
    # The loop iterates through each value in the list and doubles it.
    for i in new_list:
        temp = int(i) * 2
        # The if-statement determines whether the doubled value is less than 10. If the value is less than 9, then the
        # program iterates through the doubled value and adds them.
        if int(temp) < 10:
            double_list += int(temp)
        else:
            new_temp = str(temp)
            temp_list = list(new_temp.strip())
            for j in temp_list:
                double_list += int(j)

    return double_list


def sum_of_odd(number):
    # Changes the data type of the parameter into a string to use slicing feature. Then the program reverses the credit
    # card number and puts all the second digits from left to right into a new list.
    str_number = str(number)
    temp_number = str_number[::-1]
    new_number = temp_number[0::2]
    new_list = list(new_number.strip())
    odd_list = 0
    # The loop iterates through the list and adds the values to a new variable.
    for i in new_list:
        odd_list += int(i)

    return odd_list


# This function returns the first or first two values in the credit card.
def get_prefix(number, length):
    str_number = str(number)
    return int(str_number[0:length])


# This function returns a true boolean value if the first values are 4, 5, 37, or 6. Otherwise it returns a false
# boolean value.
def prefix(number):
    if (get_prefix(number, 1) == 4) or (get_prefix(number, 1) == 5) or (get_prefix(number, 2) == 37) or (
            get_prefix(number, 1) == 6):
        return True
    else:
        return False


# This function determines whether a credit card is valid or not.
def valid(number):
    if (size(number)) and (prefix(number)) and ((sum_of_double_even(number) + sum_of_odd(number)) % 10 == 0):
        return True
    else:
        return False


# This function receives an Entry object and sends the user's input into the valid function to check if the credit
# card number is valid.
def message_box(entry_form1, entry_form2):
    user = entry_form2.get()
    if_value = valid(user)
    # The if-statement is used to show whether the credit card is valid or not by using a showinfo or showerror message
    # box.
    if if_value:
        tkinter.messagebox.showinfo("Credit Card Validation", entry_form1.get() + ', your Credit Card is Valid!')
    else:
        tkinter.messagebox.showerror("Credit Card Invalidation", entry_form1.get() + ', your Credit Card is Invalid!')


# The main function creates the tkinter GUI program and all the features.
def main():
    root = Tk()
    root.title('Credit Card Validation')
    root.geometry('600x200')
    root.grid_columnconfigure((0, 1), weight=1)
    root.configure(borderwidth="3")
    root.configure(relief="sunken")
    root.configure(highlightbackground="#d9d9d9")
    root.configure(highlightcolor="black")
    root.configure(background="#b3e5e4")
    label1 = Label(root, text="Enter Name", font=('Helvetica', 18, 'bold'))
    label1.grid(row=3, column=0)
    label2 = Label(root, text="Enter Credit Card Number", font=('Helvetica', 18, 'bold'))
    label2.grid(row=4, column=0)
    entry_form1 = Entry(root, width=40)
    entry_form1.grid(row=3, column=1, columnspan=2)
    entry_form2 = Entry(root, width=40)
    entry_form2.grid(row=4, column=1, columnspan=2)
    submit = Button(root, text="Check Validation", command=lambda: message_box(entry_form1, entry_form2))
    submit.grid(row=6, column=0)
    submit1 = Button(root, text="Quit", command=root.quit)
    submit1.grid(row=6, column=1)
    root.mainloop()


if __name__ == "__main__":
    main()
