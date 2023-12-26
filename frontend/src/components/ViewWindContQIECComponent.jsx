import React, { Component } from 'react'
import WindContQIECService from '../services/WindContQIECService'

class ViewWindContQIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windContQIEC: {}
        }
    }

    componentDidMount(){
        WindContQIECService.getWindContQIECById(this.state.id).then( res => {
            this.setState({windContQIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindContQIEC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> iqh1:&emsp; </label>
                            <div> { this.state.windContQIEC.iqh1 }</div>
                        </div>
                        <div className = "row">
                            <label> iqmax:&emsp; </label>
                            <div> { this.state.windContQIEC.iqmax }</div>
                        </div>
                        <div className = "row">
                            <label> iqmin:&emsp; </label>
                            <div> { this.state.windContQIEC.iqmin }</div>
                        </div>
                        <div className = "row">
                            <label> iqpost:&emsp; </label>
                            <div> { this.state.windContQIEC.iqpost }</div>
                        </div>
                        <div className = "row">
                            <label> kiq:&emsp; </label>
                            <div> { this.state.windContQIEC.kiq }</div>
                        </div>
                        <div className = "row">
                            <label> kiu:&emsp; </label>
                            <div> { this.state.windContQIEC.kiu }</div>
                        </div>
                        <div className = "row">
                            <label> kpq:&emsp; </label>
                            <div> { this.state.windContQIEC.kpq }</div>
                        </div>
                        <div className = "row">
                            <label> kpu:&emsp; </label>
                            <div> { this.state.windContQIEC.kpu }</div>
                        </div>
                        <div className = "row">
                            <label> kqv:&emsp; </label>
                            <div> { this.state.windContQIEC.kqv }</div>
                        </div>
                        <div className = "row">
                            <label> qmax:&emsp; </label>
                            <div> { this.state.windContQIEC.qmax }</div>
                        </div>
                        <div className = "row">
                            <label> qmin:&emsp; </label>
                            <div> { this.state.windContQIEC.qmin }</div>
                        </div>
                        <div className = "row">
                            <label> rdroop:&emsp; </label>
                            <div> { this.state.windContQIEC.rdroop }</div>
                        </div>
                        <div className = "row">
                            <label> tiq:&emsp; </label>
                            <div> { this.state.windContQIEC.tiq }</div>
                        </div>
                        <div className = "row">
                            <label> tpfilt:&emsp; </label>
                            <div> { this.state.windContQIEC.tpfilt }</div>
                        </div>
                        <div className = "row">
                            <label> tpost:&emsp; </label>
                            <div> { this.state.windContQIEC.tpost }</div>
                        </div>
                        <div className = "row">
                            <label> tqord:&emsp; </label>
                            <div> { this.state.windContQIEC.tqord }</div>
                        </div>
                        <div className = "row">
                            <label> tufilt:&emsp; </label>
                            <div> { this.state.windContQIEC.tufilt }</div>
                        </div>
                        <div className = "row">
                            <label> udb1:&emsp; </label>
                            <div> { this.state.windContQIEC.udb1 }</div>
                        </div>
                        <div className = "row">
                            <label> udb2:&emsp; </label>
                            <div> { this.state.windContQIEC.udb2 }</div>
                        </div>
                        <div className = "row">
                            <label> umax:&emsp; </label>
                            <div> { this.state.windContQIEC.umax }</div>
                        </div>
                        <div className = "row">
                            <label> umin:&emsp; </label>
                            <div> { this.state.windContQIEC.umin }</div>
                        </div>
                        <div className = "row">
                            <label> uqdip:&emsp; </label>
                            <div> { this.state.windContQIEC.uqdip }</div>
                        </div>
                        <div className = "row">
                            <label> uref0:&emsp; </label>
                            <div> { this.state.windContQIEC.uref0 }</div>
                        </div>
                        <div className = "row">
                            <label> windLVRTQcontrolModesType:&emsp; </label>
                            <div> { this.state.windContQIEC.windLVRTQcontrolModesType }</div>
                        </div>
                        <div className = "row">
                            <label> windQcontrolModesType:&emsp; </label>
                            <div> { this.state.windContQIEC.windQcontrolModesType }</div>
                        </div>
                        <div className = "row">
                            <label> xdroop:&emsp; </label>
                            <div> { this.state.windContQIEC.xdroop }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindContQIECComponent
