import React, { Component } from 'react'
import GovCT2Service from '../services/GovCT2Service'

class ViewGovCT2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govCT2: {}
        }
    }

    componentDidMount(){
        GovCT2Service.getGovCT2ById(this.state.id).then( res => {
            this.setState({govCT2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovCT2 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> aset:&emsp; </label>
                            <div> { this.state.govCT2.aset }</div>
                        </div>
                        <div className = "row">
                            <label> db:&emsp; </label>
                            <div> { this.state.govCT2.db }</div>
                        </div>
                        <div className = "row">
                            <label> dm:&emsp; </label>
                            <div> { this.state.govCT2.dm }</div>
                        </div>
                        <div className = "row">
                            <label> flim1:&emsp; </label>
                            <div> { this.state.govCT2.flim1 }</div>
                        </div>
                        <div className = "row">
                            <label> flim10:&emsp; </label>
                            <div> { this.state.govCT2.flim10 }</div>
                        </div>
                        <div className = "row">
                            <label> flim2:&emsp; </label>
                            <div> { this.state.govCT2.flim2 }</div>
                        </div>
                        <div className = "row">
                            <label> flim3:&emsp; </label>
                            <div> { this.state.govCT2.flim3 }</div>
                        </div>
                        <div className = "row">
                            <label> flim4:&emsp; </label>
                            <div> { this.state.govCT2.flim4 }</div>
                        </div>
                        <div className = "row">
                            <label> flim5:&emsp; </label>
                            <div> { this.state.govCT2.flim5 }</div>
                        </div>
                        <div className = "row">
                            <label> flim6:&emsp; </label>
                            <div> { this.state.govCT2.flim6 }</div>
                        </div>
                        <div className = "row">
                            <label> flim7:&emsp; </label>
                            <div> { this.state.govCT2.flim7 }</div>
                        </div>
                        <div className = "row">
                            <label> flim8:&emsp; </label>
                            <div> { this.state.govCT2.flim8 }</div>
                        </div>
                        <div className = "row">
                            <label> flim9:&emsp; </label>
                            <div> { this.state.govCT2.flim9 }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.govCT2.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kdgov:&emsp; </label>
                            <div> { this.state.govCT2.kdgov }</div>
                        </div>
                        <div className = "row">
                            <label> kigov:&emsp; </label>
                            <div> { this.state.govCT2.kigov }</div>
                        </div>
                        <div className = "row">
                            <label> kiload:&emsp; </label>
                            <div> { this.state.govCT2.kiload }</div>
                        </div>
                        <div className = "row">
                            <label> kimw:&emsp; </label>
                            <div> { this.state.govCT2.kimw }</div>
                        </div>
                        <div className = "row">
                            <label> kpgov:&emsp; </label>
                            <div> { this.state.govCT2.kpgov }</div>
                        </div>
                        <div className = "row">
                            <label> kpload:&emsp; </label>
                            <div> { this.state.govCT2.kpload }</div>
                        </div>
                        <div className = "row">
                            <label> kturb:&emsp; </label>
                            <div> { this.state.govCT2.kturb }</div>
                        </div>
                        <div className = "row">
                            <label> ldref:&emsp; </label>
                            <div> { this.state.govCT2.ldref }</div>
                        </div>
                        <div className = "row">
                            <label> maxerr:&emsp; </label>
                            <div> { this.state.govCT2.maxerr }</div>
                        </div>
                        <div className = "row">
                            <label> minerr:&emsp; </label>
                            <div> { this.state.govCT2.minerr }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govCT2.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> plim1:&emsp; </label>
                            <div> { this.state.govCT2.plim1 }</div>
                        </div>
                        <div className = "row">
                            <label> plim10:&emsp; </label>
                            <div> { this.state.govCT2.plim10 }</div>
                        </div>
                        <div className = "row">
                            <label> plim2:&emsp; </label>
                            <div> { this.state.govCT2.plim2 }</div>
                        </div>
                        <div className = "row">
                            <label> plim3:&emsp; </label>
                            <div> { this.state.govCT2.plim3 }</div>
                        </div>
                        <div className = "row">
                            <label> plim4:&emsp; </label>
                            <div> { this.state.govCT2.plim4 }</div>
                        </div>
                        <div className = "row">
                            <label> plim5:&emsp; </label>
                            <div> { this.state.govCT2.plim5 }</div>
                        </div>
                        <div className = "row">
                            <label> plim6:&emsp; </label>
                            <div> { this.state.govCT2.plim6 }</div>
                        </div>
                        <div className = "row">
                            <label> plim7:&emsp; </label>
                            <div> { this.state.govCT2.plim7 }</div>
                        </div>
                        <div className = "row">
                            <label> plim8:&emsp; </label>
                            <div> { this.state.govCT2.plim8 }</div>
                        </div>
                        <div className = "row">
                            <label> plim9:&emsp; </label>
                            <div> { this.state.govCT2.plim9 }</div>
                        </div>
                        <div className = "row">
                            <label> prate:&emsp; </label>
                            <div> { this.state.govCT2.prate }</div>
                        </div>
                        <div className = "row">
                            <label> r:&emsp; </label>
                            <div> { this.state.govCT2.r }</div>
                        </div>
                        <div className = "row">
                            <label> rclose:&emsp; </label>
                            <div> { this.state.govCT2.rclose }</div>
                        </div>
                        <div className = "row">
                            <label> rdown:&emsp; </label>
                            <div> { this.state.govCT2.rdown }</div>
                        </div>
                        <div className = "row">
                            <label> ropen:&emsp; </label>
                            <div> { this.state.govCT2.ropen }</div>
                        </div>
                        <div className = "row">
                            <label> rselect:&emsp; </label>
                            <div> { this.state.govCT2.rselect }</div>
                        </div>
                        <div className = "row">
                            <label> rup:&emsp; </label>
                            <div> { this.state.govCT2.rup }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.govCT2.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tact:&emsp; </label>
                            <div> { this.state.govCT2.tact }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.govCT2.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.govCT2.tc }</div>
                        </div>
                        <div className = "row">
                            <label> tdgov:&emsp; </label>
                            <div> { this.state.govCT2.tdgov }</div>
                        </div>
                        <div className = "row">
                            <label> teng:&emsp; </label>
                            <div> { this.state.govCT2.teng }</div>
                        </div>
                        <div className = "row">
                            <label> tfload:&emsp; </label>
                            <div> { this.state.govCT2.tfload }</div>
                        </div>
                        <div className = "row">
                            <label> tpelec:&emsp; </label>
                            <div> { this.state.govCT2.tpelec }</div>
                        </div>
                        <div className = "row">
                            <label> tsa:&emsp; </label>
                            <div> { this.state.govCT2.tsa }</div>
                        </div>
                        <div className = "row">
                            <label> tsb:&emsp; </label>
                            <div> { this.state.govCT2.tsb }</div>
                        </div>
                        <div className = "row">
                            <label> vmax:&emsp; </label>
                            <div> { this.state.govCT2.vmax }</div>
                        </div>
                        <div className = "row">
                            <label> vmin:&emsp; </label>
                            <div> { this.state.govCT2.vmin }</div>
                        </div>
                        <div className = "row">
                            <label> wfnl:&emsp; </label>
                            <div> { this.state.govCT2.wfnl }</div>
                        </div>
                        <div className = "row">
                            <label> wfspd:&emsp; </label>
                            <div> { this.state.govCT2.wfspd }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovCT2Component
