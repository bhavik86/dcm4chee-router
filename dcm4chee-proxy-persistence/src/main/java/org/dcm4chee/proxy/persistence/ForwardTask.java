/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is part of dcm4che, an implementation of DICOM(TM) in
 * Java(TM), hosted at https://github.com/gunterze/dcm4che.
 *
 * The Initial Developer of the Original Code is
 * Agfa Healthcare.
 * Portions created by the Initial Developer are Copyright (C) 2011
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 * See @authors listed below
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * ***** END LICENSE BLOCK ***** */

package org.dcm4chee.proxy.persistence;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Michael Backhaus <michael.backhaus@agfa.com>
 */
@NamedQueries({
    @NamedQuery(
            name="//TODO//",
            query="//TODO//")
})
@Entity
@Table(name = "forward_task")
public class ForwardTask {
    
    public final String SCHEDULED = "scheduled";
    public final String COMPLETED = "completed";
    public final String ERROR = "error";
    
    @Id
    @GeneratedValue
    @Column(name = "pk")
    private int pk;
    
    @Basic(optional = false)
    @Column(name = "series_iuid", updatable = false, unique = true)
    private String seriesInstanceUID;
    
    @Basic(optional = false)
    @Column(name = "fileset_uid", unique = true)
    private String filesetUID;
    
    @Basic(optional = false)
    @Column(name= "fileset_status")
    private String filesetStatus;
    
    @Basic(optional = true)
    @Column(name = "status_code")
    private String statusCode;

    public void setPk(int pk) {
        this.pk = pk;
    }

    public int getPk() {
        return pk;
    }

    public void setSeriesInstanceUID(String seriesInstanceUID) {
        this.seriesInstanceUID = seriesInstanceUID;
    }

    public String getSeriesInstanceUID() {
        return seriesInstanceUID;
    }

    public void setFilesetUID(String filesetUID) {
        this.filesetUID = filesetUID;
    }

    public String getFilesetUID() {
        return filesetUID;
    }

    public void setFilesetStatus(String filesetStatus) {
        this.filesetStatus = filesetStatus;
    }

    public String getFilesetStatus() {
        return filesetStatus;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }
}