import React, { Component } from 'react'
import WindPlantFreqPcontrolIECService from '../services/WindPlantFreqPcontrolIECService'

class ViewWindPlantFreqPcontrolIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windPlantFreqPcontrolIEC: {}
        }
    }

    componentDidMount(){
        WindPlantFreqPcontrolIECService.getWindPlantFreqPcontrolIECById(this.state.id).then( res => {
            this.setState({windPlantFreqPcontrolIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindPlantFreqPcontrolIEC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> dprefmax:&emsp; </label>
                            <div> { this.state.windPlantFreqPcontrolIEC.dprefmax }</div>
                        </div>
                        <div className = "row">
                            <label> dprefmin:&emsp; </label>
                            <div> { this.state.windPlantFreqPcontrolIEC.dprefmin }</div>
                        </div>
                        <div className = "row">
                            <label> kiwpp:&emsp; </label>
                            <div> { this.state.windPlantFreqPcontrolIEC.kiwpp }</div>
                        </div>
                        <div className = "row">
                            <label> kpwpp:&emsp; </label>
                            <div> { this.state.windPlantFreqPcontrolIEC.kpwpp }</div>
                        </div>
                        <div className = "row">
                            <label> prefmax:&emsp; </label>
                            <div> { this.state.windPlantFreqPcontrolIEC.prefmax }</div>
                        </div>
                        <div className = "row">
                            <label> prefmin:&emsp; </label>
                            <div> { this.state.windPlantFreqPcontrolIEC.prefmin }</div>
                        </div>
                        <div className = "row">
                            <label> tpft:&emsp; </label>
                            <div> { this.state.windPlantFreqPcontrolIEC.tpft }</div>
                        </div>
                        <div className = "row">
                            <label> tpfv:&emsp; </label>
                            <div> { this.state.windPlantFreqPcontrolIEC.tpfv }</div>
                        </div>
                        <div className = "row">
                            <label> twpffilt:&emsp; </label>
                            <div> { this.state.windPlantFreqPcontrolIEC.twpffilt }</div>
                        </div>
                        <div className = "row">
                            <label> twppfilt:&emsp; </label>
                            <div> { this.state.windPlantFreqPcontrolIEC.twppfilt }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindPlantFreqPcontrolIECComponent
