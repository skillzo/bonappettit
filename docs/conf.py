# Configuration file for the Sphinx documentation builder.
#
# This file only contains a selection of the most common options. For a full
# list see the documentation:
# https://www.sphinx-doc.org/en/master/usage/configuration.html

# -- Path setup --------------------------------------------------------------

# If extensions (or modules to document with autodoc) are in another directory,
# add these directories to sys.path here. If the directory is relative to the
# documentation root, use os.path.abspath to make it absolute, like shown here.
#
import os
import sys
sys.path.insert(0, r'/home/gradle/softpos/scripts/docs_env/_config/extensions')

sys.path.insert(0, r'/home/gradle/softpos/scripts/docs_env')

from sdkversion import *

from sphinx_helper import files_to_latex_docs, files_to_docxs

# -- Project information -----------------------------------------------------

project = 'SoftPos'
copyright = '2021, Alcinéo'
author = 'Alcinéo'

master_doc = 'index'

# -- General configuration ---------------------------------------------------


# Add any Sphinx extension module names here, as strings. They can be
# extensions coming with Sphinx (named 'sphinx.ext.*') or your custom
# ones.
extensions = ['sphinxcontrib.plantuml', 'sphinx_svn', 'docxbuilder']
plantuml = r'/opt/java/openjdk/bin/java -jar /home/gradle/softpos/scripts/docs_env/_static/plantuml.1.2019.13.jar'

# Add any paths that contain templates here, relative to this directory.
templates_path = [r'/home/gradle/softpos/scripts/docs_env/_config/templates']

# List of patterns, relative to source directory, that match files and
# directories to ignore when looking for source files.
# This pattern also affects html_static_path and html_extra_path.
exclude_patterns = []


# -- Options for HTML output -------------------------------------------------

# The theme to use for HTML and HTML Help pages.  See the documentation for
# a list of builtin themes.
#
html_theme = 'sphinx_rtd_theme'

# Add any paths that contain custom static files (such as style sheets) here,
# relative to this directory. They are copied after the builtin static files,
# so a file named "default.css" will overwrite the builtin "default.css".
static_path = r'/home/gradle/softpos/scripts/docs_env/_static'
html_static_path = [static_path]

# today display only the year for disclaimers
today_fmt = '%Y'

latex_engine = 'xelatex'
latex_elements = {
    # ... other latex elements ...
    'preamble': r'\usepackage{eforms}'
}
input_list = []
input_list.append(r'Demo-UserGuide.rst')

latex_documents = files_to_latex_docs(input_list)
docx_documents = files_to_docxs(input_list)

from sphinx_conf import *

html_logo = os.path.join(static_path, 'logo.jpg')
latex_logo = os.path.join(static_path, 'logo.jpg')