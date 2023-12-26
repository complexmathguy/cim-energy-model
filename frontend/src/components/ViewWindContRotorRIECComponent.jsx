import React, { Component } from 'react'
import WindContRotorRIECService from '../services/WindContRotorRIECService'

class ViewWindContRotorRIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windContRotorRIEC: {}
        }
    }

    componentDidMount(){
        WindContRotorRIECService.getWindContRotorRIECById(this.state.id).then( res => {
            this.setState({windContRotorRIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindContRotorRIEC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> kirr:&emsp; </label>
                            <div> { this.state.windContRotorRIEC.kirr }</div>
                        </div>
                        <div className = "row">
                            <label> komegafilt:&emsp; </label>
                            <div> { this.state.windContRotorRIEC.komegafilt }</div>
                        </div>
                        <div className = "row">
                            <label> kpfilt:&emsp; </label>
                            <div> { this.state.windContRotorRIEC.kpfilt }</div>
                        </div>
                        <div className = "row">
                            <label> kprr:&emsp; </label>
                            <div> { this.state.windContRotorRIEC.kprr }</div>
                        </div>
                        <div className = "row">
                            <label> rmax:&emsp; </label>
                            <div> { this.state.windContRotorRIEC.rmax }</div>
                        </div>
                        <div className = "row">
                            <label> rmin:&emsp; </label>
                            <div> { this.state.windContRotorRIEC.rmin }</div>
                        </div>
                        <div className = "row">
                            <label> tomegafilt:&emsp; </label>
                            <div> { this.state.windContRotorRIEC.tomegafilt }</div>
                        </div>
                        <div className = "row">
                            <label> tpfilt:&emsp; </label>
                            <div> { this.state.windContRotorRIEC.tpfilt }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindContRotorRIECComponent
