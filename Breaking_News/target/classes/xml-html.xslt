<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    table {
                    font-family: arial, sans-serif;
                    border-collapse: collapse;
                    width:
                    100%;
                    }
                    td, th {
                    border: 1px solid #dddddd;
                    text-align: right;
                    padding: 8px;
                    }
                    tr:nth-child(even) {
                    background-color: #dddddd;
                    }
                </style>
            </head>
            <body>
                <h2 style="text-align:center">חדשות ynet</h2>
                <table border="1">

                    <tr  bgcolor = "#9acd32">
                        <th>תיאור</th>
                        <th>כתבה</th>
                        <th>כותרת</th>

                    </tr>
                    <xsl:for-each select="rss/channel/item">
                        <tr>
                            <td>
                                <xsl:value-of select="description"/>
                            </td>
                            <td>
                                <xsl:value-of select="link" />
                            </td>
                            <td>
                                <xsl:value-of select="title" />
                            </td>


                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>