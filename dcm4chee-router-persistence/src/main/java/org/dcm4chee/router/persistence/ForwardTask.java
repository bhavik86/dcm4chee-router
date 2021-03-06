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

package org.dcm4chee.router.persistence;

import java.io.Serializable;

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
    @NamedQuery(name="ForwardTask.updateStatus",
            query="UPDATE ForwardTask ft SET ft.forwardTaskStatus=?1, ft.errorCode=?2 " +
                  "WHERE ft.pk=?3"),
    @NamedQuery(name="ForwardTask.findByStatus",
            query="SELECT f from ForwardTask f WHERE f.forwardTaskStatus=?1")
})
@Entity
@Table(name = "forward_task")
public class ForwardTask implements Serializable{
    
    private static final long serialVersionUID = 5400645502128519891L;
    
    public static final String UPDATE_STATUS = "ForwardTask.updateStatus";
    public static final String FIND_BY_STATUS_CODE = "ForwardTask.findByStatus";
    
    @Id
    @GeneratedValue
    @Column(name = "pk")
    private int pk;

    @Basic(optional = false)
    @Column(name = "source_aet")
    private String sourceAET;
    
    @Basic(optional = false)
    @Column(name = "destination_aet")
    private String destinationAET;
    
    @Basic(optional = false)
    @Column(name = "fileset_uid")
    private String filesetUID;
    
    @Basic(optional = false)
    @Column(name = "series_iuid", updatable = false)
    private String seriesInstanceUID;
    
    @Basic(optional = false)
    @Column(name= "forwardtask_status")
    private ForwardTaskStatus forwardTaskStatus;
    
    @Basic(optional = true)
    @Column(name = "error_code")
    private String errorCode;

    public void setPk(int pk) {
        this.pk = pk;
    }

    public int getPk() {
        return pk;
    }

    public void setFilesetUID(String filesetUID) {
        this.filesetUID = filesetUID;
    }

    public String getFilesetUID() {
        return filesetUID;
    }

    public void setForwardTaskStatus(ForwardTaskStatus status) {
        this.forwardTaskStatus = status;
    }

    public ForwardTaskStatus getForwardTaskStatus() {
        return forwardTaskStatus;
    }

    public void setErrorCode(String code) {
        this.errorCode = code;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setDestinationAET(String targetAET) {
        this.destinationAET = targetAET;
    }

    public String getDestinationAET() {
        return destinationAET;
    }

    public void setSeriesInstanceUID(String seriesInstanceUID) {
        this.seriesInstanceUID = seriesInstanceUID;
    }

    public String getSeriesInstanceUID() {
        return seriesInstanceUID;
    }

    public void setSourceAET(String sourceAET) {
        this.sourceAET = sourceAET;
    }

    public String getSourceAET() {
        return sourceAET;
    }
}
