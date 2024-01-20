from bs4 import BeautifulSoup

# Read HTML content from the file
with open("content.txt", "r") as file:
    content = file.read()

# Create BeautifulSoup object
soup = BeautifulSoup(content, 'html.parser')

# Function to decode the pattern
def decode_pattern(element):
    result = ''
    for child in element.children:
        if child.name == 'div':
            result += decode_pattern(child)
        else:
            result += child.strip() + ' '
    return result

# Decode the pattern from the HTML
decoded_content = decode_pattern(soup.body)

# Print the final content
print(decoded_content)