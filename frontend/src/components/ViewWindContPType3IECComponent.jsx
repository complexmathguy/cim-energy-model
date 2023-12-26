import React, { Component } from 'react'
import WindContPType3IECService from '../services/WindContPType3IECService'

class ViewWindContPType3IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windContPType3IEC: {}
        }
    }

    componentDidMount(){
        WindContPType3IECService.getWindContPType3IECById(this.state.id).then( res => {
            this.setState({windContPType3IEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindContPType3IEC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> dpmax:&emsp; </label>
                            <div> { this.state.windContPType3IEC.dpmax }</div>
                        </div>
                        <div className = "row">
                            <label> dtrisemaxlvrt:&emsp; </label>
                            <div> { this.state.windContPType3IEC.dtrisemaxlvrt }</div>
                        </div>
                        <div className = "row">
                            <label> kdtd:&emsp; </label>
                            <div> { this.state.windContPType3IEC.kdtd }</div>
                        </div>
                        <div className = "row">
                            <label> kip:&emsp; </label>
                            <div> { this.state.windContPType3IEC.kip }</div>
                        </div>
                        <div className = "row">
                            <label> kpp:&emsp; </label>
                            <div> { this.state.windContPType3IEC.kpp }</div>
                        </div>
                        <div className = "row">
                            <label> mplvrt:&emsp; </label>
                            <div> { this.state.windContPType3IEC.mplvrt }</div>
                        </div>
                        <div className = "row">
                            <label> omegaoffset:&emsp; </label>
                            <div> { this.state.windContPType3IEC.omegaoffset }</div>
                        </div>
                        <div className = "row">
                            <label> pdtdmax:&emsp; </label>
                            <div> { this.state.windContPType3IEC.pdtdmax }</div>
                        </div>
                        <div className = "row">
                            <label> rramp:&emsp; </label>
                            <div> { this.state.windContPType3IEC.rramp }</div>
                        </div>
                        <div className = "row">
                            <label> tdvs:&emsp; </label>
                            <div> { this.state.windContPType3IEC.tdvs }</div>
                        </div>
                        <div className = "row">
                            <label> temin:&emsp; </label>
                            <div> { this.state.windContPType3IEC.temin }</div>
                        </div>
                        <div className = "row">
                            <label> tomegafilt:&emsp; </label>
                            <div> { this.state.windContPType3IEC.tomegafilt }</div>
                        </div>
                        <div className = "row">
                            <label> tpfilt:&emsp; </label>
                            <div> { this.state.windContPType3IEC.tpfilt }</div>
                        </div>
                        <div className = "row">
                            <label> tpord:&emsp; </label>
                            <div> { this.state.windContPType3IEC.tpord }</div>
                        </div>
                        <div className = "row">
                            <label> tufilt:&emsp; </label>
                            <div> { this.state.windContPType3IEC.tufilt }</div>
                        </div>
                        <div className = "row">
                            <label> tuscale:&emsp; </label>
                            <div> { this.state.windContPType3IEC.tuscale }</div>
                        </div>
                        <div className = "row">
                            <label> twref:&emsp; </label>
                            <div> { this.state.windContPType3IEC.twref }</div>
                        </div>
                        <div className = "row">
                            <label> udvs:&emsp; </label>
                            <div> { this.state.windContPType3IEC.udvs }</div>
                        </div>
                        <div className = "row">
                            <label> updip:&emsp; </label>
                            <div> { this.state.windContPType3IEC.updip }</div>
                        </div>
                        <div className = "row">
                            <label> wdtd:&emsp; </label>
                            <div> { this.state.windContPType3IEC.wdtd }</div>
                        </div>
                        <div className = "row">
                            <label> zeta:&emsp; </label>
                            <div> { this.state.windContPType3IEC.zeta }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindContPType3IECComponent
