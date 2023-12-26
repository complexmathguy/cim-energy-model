import React, { Component } from 'react'
import ExcREXSService from '../services/ExcREXSService'

class ViewExcREXSComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excREXS: {}
        }
    }

    componentDidMount(){
        ExcREXSService.getExcREXSById(this.state.id).then( res => {
            this.setState({excREXS: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcREXS Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> e1:&emsp; </label>
                            <div> { this.state.excREXS.e1 }</div>
                        </div>
                        <div className = "row">
                            <label> e2:&emsp; </label>
                            <div> { this.state.excREXS.e2 }</div>
                        </div>
                        <div className = "row">
                            <label> fbf:&emsp; </label>
                            <div> { this.state.excREXS.fbf }</div>
                        </div>
                        <div className = "row">
                            <label> flimf:&emsp; </label>
                            <div> { this.state.excREXS.flimf }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excREXS.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kd:&emsp; </label>
                            <div> { this.state.excREXS.kd }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excREXS.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kefd:&emsp; </label>
                            <div> { this.state.excREXS.kefd }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.excREXS.kf }</div>
                        </div>
                        <div className = "row">
                            <label> kh:&emsp; </label>
                            <div> { this.state.excREXS.kh }</div>
                        </div>
                        <div className = "row">
                            <label> kii:&emsp; </label>
                            <div> { this.state.excREXS.kii }</div>
                        </div>
                        <div className = "row">
                            <label> kip:&emsp; </label>
                            <div> { this.state.excREXS.kip }</div>
                        </div>
                        <div className = "row">
                            <label> ks:&emsp; </label>
                            <div> { this.state.excREXS.ks }</div>
                        </div>
                        <div className = "row">
                            <label> kvi:&emsp; </label>
                            <div> { this.state.excREXS.kvi }</div>
                        </div>
                        <div className = "row">
                            <label> kvp:&emsp; </label>
                            <div> { this.state.excREXS.kvp }</div>
                        </div>
                        <div className = "row">
                            <label> kvphz:&emsp; </label>
                            <div> { this.state.excREXS.kvphz }</div>
                        </div>
                        <div className = "row">
                            <label> nvphz:&emsp; </label>
                            <div> { this.state.excREXS.nvphz }</div>
                        </div>
                        <div className = "row">
                            <label> se1:&emsp; </label>
                            <div> { this.state.excREXS.se1 }</div>
                        </div>
                        <div className = "row">
                            <label> se2:&emsp; </label>
                            <div> { this.state.excREXS.se2 }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excREXS.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb1:&emsp; </label>
                            <div> { this.state.excREXS.tb1 }</div>
                        </div>
                        <div className = "row">
                            <label> tb2:&emsp; </label>
                            <div> { this.state.excREXS.tb2 }</div>
                        </div>
                        <div className = "row">
                            <label> tc1:&emsp; </label>
                            <div> { this.state.excREXS.tc1 }</div>
                        </div>
                        <div className = "row">
                            <label> tc2:&emsp; </label>
                            <div> { this.state.excREXS.tc2 }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excREXS.te }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.excREXS.tf }</div>
                        </div>
                        <div className = "row">
                            <label> tf1:&emsp; </label>
                            <div> { this.state.excREXS.tf1 }</div>
                        </div>
                        <div className = "row">
                            <label> tf2:&emsp; </label>
                            <div> { this.state.excREXS.tf2 }</div>
                        </div>
                        <div className = "row">
                            <label> tp:&emsp; </label>
                            <div> { this.state.excREXS.tp }</div>
                        </div>
                        <div className = "row">
                            <label> vcmax:&emsp; </label>
                            <div> { this.state.excREXS.vcmax }</div>
                        </div>
                        <div className = "row">
                            <label> vfmax:&emsp; </label>
                            <div> { this.state.excREXS.vfmax }</div>
                        </div>
                        <div className = "row">
                            <label> vfmin:&emsp; </label>
                            <div> { this.state.excREXS.vfmin }</div>
                        </div>
                        <div className = "row">
                            <label> vimax:&emsp; </label>
                            <div> { this.state.excREXS.vimax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excREXS.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excREXS.vrmin }</div>
                        </div>
                        <div className = "row">
                            <label> xc:&emsp; </label>
                            <div> { this.state.excREXS.xc }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcREXSComponent
