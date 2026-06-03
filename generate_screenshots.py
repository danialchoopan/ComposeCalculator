from PIL import Image, ImageDraw

def create_placeholder(filename, text):
    img = Image.new('RGB', (400, 800), color=(73, 109, 137))
    d = ImageDraw.Draw(img)
    d.text((150, 400), text, fill=(255, 255, 0))
    img.save(filename)

create_placeholder('screenshots/simple_mode.png', 'Simple Mode')
create_placeholder('screenshots/scientific_mode.png', 'Scientific Mode')
create_placeholder('screenshots/history.png', 'History')
