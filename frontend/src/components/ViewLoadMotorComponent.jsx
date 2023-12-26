import React, { Component } from 'react'
import LoadMotorService from '../services/LoadMotorService'

class ViewLoadMotorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            loadMotor: {}
        }
    }

    componentDidMount(){
        LoadMotorService.getLoadMotorById(this.state.id).then( res => {
            this.setState({loadMotor: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View LoadMotor Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> d:&emsp; </label>
                            <div> { this.state.loadMotor.d }</div>
                        </div>
                        <div className = "row">
                            <label> h:&emsp; </label>
                            <div> { this.state.loadMotor.h }</div>
                        </div>
                        <div className = "row">
                            <label> lfac:&emsp; </label>
                            <div> { this.state.loadMotor.lfac }</div>
                        </div>
                        <div className = "row">
                            <label> lp:&emsp; </label>
                            <div> { this.state.loadMotor.lp }</div>
                        </div>
                        <div className = "row">
                            <label> lpp:&emsp; </label>
                            <div> { this.state.loadMotor.lpp }</div>
                        </div>
                        <div className = "row">
                            <label> ls:&emsp; </label>
                            <div> { this.state.loadMotor.ls }</div>
                        </div>
                        <div className = "row">
                            <label> pfrac:&emsp; </label>
                            <div> { this.state.loadMotor.pfrac }</div>
                        </div>
                        <div className = "row">
                            <label> ra:&emsp; </label>
                            <div> { this.state.loadMotor.ra }</div>
                        </div>
                        <div className = "row">
                            <label> tbkr:&emsp; </label>
                            <div> { this.state.loadMotor.tbkr }</div>
                        </div>
                        <div className = "row">
                            <label> tpo:&emsp; </label>
                            <div> { this.state.loadMotor.tpo }</div>
                        </div>
                        <div className = "row">
                            <label> tppo:&emsp; </label>
                            <div> { this.state.loadMotor.tppo }</div>
                        </div>
                        <div className = "row">
                            <label> tv:&emsp; </label>
                            <div> { this.state.loadMotor.tv }</div>
                        </div>
                        <div className = "row">
                            <label> vt:&emsp; </label>
                            <div> { this.state.loadMotor.vt }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLoadMotorComponent
