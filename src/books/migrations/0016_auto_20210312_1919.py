# Generated by Django 3.1.7 on 2021-03-12 16:19

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('books', '0015_auto_20210312_1854'),
    ]

    operations = [
        migrations.AddField(
            model_name='book',
            name='chapters',
            field=models.ManyToManyField(related_name='book', to='books.Chapter'),
        ),
        migrations.DeleteModel(
            name='Chapters',
        ),
    ]