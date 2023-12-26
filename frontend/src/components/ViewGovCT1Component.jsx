import React, { Component } from 'react'
import GovCT1Service from '../services/GovCT1Service'

class ViewGovCT1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govCT1: {}
        }
    }

    componentDidMount(){
        GovCT1Service.getGovCT1ById(this.state.id).then( res => {
            this.setState({govCT1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovCT1 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> aset:&emsp; </label>
                            <div> { this.state.govCT1.aset }</div>
                        </div>
                        <div className = "row">
                            <label> db:&emsp; </label>
                            <div> { this.state.govCT1.db }</div>
                        </div>
                        <div className = "row">
                            <label> dm:&emsp; </label>
                            <div> { this.state.govCT1.dm }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.govCT1.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kdgov:&emsp; </label>
                            <div> { this.state.govCT1.kdgov }</div>
                        </div>
                        <div className = "row">
                            <label> kigov:&emsp; </label>
                            <div> { this.state.govCT1.kigov }</div>
                        </div>
                        <div className = "row">
                            <label> kiload:&emsp; </label>
                            <div> { this.state.govCT1.kiload }</div>
                        </div>
                        <div className = "row">
                            <label> kimw:&emsp; </label>
                            <div> { this.state.govCT1.kimw }</div>
                        </div>
                        <div className = "row">
                            <label> kpgov:&emsp; </label>
                            <div> { this.state.govCT1.kpgov }</div>
                        </div>
                        <div className = "row">
                            <label> kpload:&emsp; </label>
                            <div> { this.state.govCT1.kpload }</div>
                        </div>
                        <div className = "row">
                            <label> kturb:&emsp; </label>
                            <div> { this.state.govCT1.kturb }</div>
                        </div>
                        <div className = "row">
                            <label> ldref:&emsp; </label>
                            <div> { this.state.govCT1.ldref }</div>
                        </div>
                        <div className = "row">
                            <label> maxerr:&emsp; </label>
                            <div> { this.state.govCT1.maxerr }</div>
                        </div>
                        <div className = "row">
                            <label> minerr:&emsp; </label>
                            <div> { this.state.govCT1.minerr }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govCT1.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> r:&emsp; </label>
                            <div> { this.state.govCT1.r }</div>
                        </div>
                        <div className = "row">
                            <label> rclose:&emsp; </label>
                            <div> { this.state.govCT1.rclose }</div>
                        </div>
                        <div className = "row">
                            <label> rdown:&emsp; </label>
                            <div> { this.state.govCT1.rdown }</div>
                        </div>
                        <div className = "row">
                            <label> ropen:&emsp; </label>
                            <div> { this.state.govCT1.ropen }</div>
                        </div>
                        <div className = "row">
                            <label> rselect:&emsp; </label>
                            <div> { this.state.govCT1.rselect }</div>
                        </div>
                        <div className = "row">
                            <label> rup:&emsp; </label>
                            <div> { this.state.govCT1.rup }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.govCT1.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tact:&emsp; </label>
                            <div> { this.state.govCT1.tact }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.govCT1.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.govCT1.tc }</div>
                        </div>
                        <div className = "row">
                            <label> tdgov:&emsp; </label>
                            <div> { this.state.govCT1.tdgov }</div>
                        </div>
                        <div className = "row">
                            <label> teng:&emsp; </label>
                            <div> { this.state.govCT1.teng }</div>
                        </div>
                        <div className = "row">
                            <label> tfload:&emsp; </label>
                            <div> { this.state.govCT1.tfload }</div>
                        </div>
                        <div className = "row">
                            <label> tpelec:&emsp; </label>
                            <div> { this.state.govCT1.tpelec }</div>
                        </div>
                        <div className = "row">
                            <label> tsa:&emsp; </label>
                            <div> { this.state.govCT1.tsa }</div>
                        </div>
                        <div className = "row">
                            <label> tsb:&emsp; </label>
                            <div> { this.state.govCT1.tsb }</div>
                        </div>
                        <div className = "row">
                            <label> vmax:&emsp; </label>
                            <div> { this.state.govCT1.vmax }</div>
                        </div>
                        <div className = "row">
                            <label> vmin:&emsp; </label>
                            <div> { this.state.govCT1.vmin }</div>
                        </div>
                        <div className = "row">
                            <label> wfnl:&emsp; </label>
                            <div> { this.state.govCT1.wfnl }</div>
                        </div>
                        <div className = "row">
                            <label> wfspd:&emsp; </label>
                            <div> { this.state.govCT1.wfspd }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovCT1Component
