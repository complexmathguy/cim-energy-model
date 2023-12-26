import React, { Component } from 'react'
import WindPlantReactiveControlIECService from '../services/WindPlantReactiveControlIECService'

class ViewWindPlantReactiveControlIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windPlantReactiveControlIEC: {}
        }
    }

    componentDidMount(){
        WindPlantReactiveControlIECService.getWindPlantReactiveControlIECById(this.state.id).then( res => {
            this.setState({windPlantReactiveControlIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindPlantReactiveControlIEC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> kiwpx:&emsp; </label>
                            <div> { this.state.windPlantReactiveControlIEC.kiwpx }</div>
                        </div>
                        <div className = "row">
                            <label> kpwpx:&emsp; </label>
                            <div> { this.state.windPlantReactiveControlIEC.kpwpx }</div>
                        </div>
                        <div className = "row">
                            <label> kwpqu:&emsp; </label>
                            <div> { this.state.windPlantReactiveControlIEC.kwpqu }</div>
                        </div>
                        <div className = "row">
                            <label> mwppf:&emsp; </label>
                            <div> { this.state.windPlantReactiveControlIEC.mwppf }</div>
                        </div>
                        <div className = "row">
                            <label> mwpu:&emsp; </label>
                            <div> { this.state.windPlantReactiveControlIEC.mwpu }</div>
                        </div>
                        <div className = "row">
                            <label> twppfilt:&emsp; </label>
                            <div> { this.state.windPlantReactiveControlIEC.twppfilt }</div>
                        </div>
                        <div className = "row">
                            <label> twpqfilt:&emsp; </label>
                            <div> { this.state.windPlantReactiveControlIEC.twpqfilt }</div>
                        </div>
                        <div className = "row">
                            <label> twpufilt:&emsp; </label>
                            <div> { this.state.windPlantReactiveControlIEC.twpufilt }</div>
                        </div>
                        <div className = "row">
                            <label> txft:&emsp; </label>
                            <div> { this.state.windPlantReactiveControlIEC.txft }</div>
                        </div>
                        <div className = "row">
                            <label> txfv:&emsp; </label>
                            <div> { this.state.windPlantReactiveControlIEC.txfv }</div>
                        </div>
                        <div className = "row">
                            <label> uwpqdip:&emsp; </label>
                            <div> { this.state.windPlantReactiveControlIEC.uwpqdip }</div>
                        </div>
                        <div className = "row">
                            <label> xrefmax:&emsp; </label>
                            <div> { this.state.windPlantReactiveControlIEC.xrefmax }</div>
                        </div>
                        <div className = "row">
                            <label> xrefmin:&emsp; </label>
                            <div> { this.state.windPlantReactiveControlIEC.xrefmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindPlantReactiveControlIECComponent
