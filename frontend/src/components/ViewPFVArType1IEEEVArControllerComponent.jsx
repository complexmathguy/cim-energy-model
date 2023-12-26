import React, { Component } from 'react'
import PFVArType1IEEEVArControllerService from '../services/PFVArType1IEEEVArControllerService'

class ViewPFVArType1IEEEVArControllerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pFVArType1IEEEVArController: {}
        }
    }

    componentDidMount(){
        PFVArType1IEEEVArControllerService.getPFVArType1IEEEVArControllerById(this.state.id).then( res => {
            this.setState({pFVArType1IEEEVArController: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PFVArType1IEEEVArController Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> tvarc:&emsp; </label>
                            <div> { this.state.pFVArType1IEEEVArController.tvarc }</div>
                        </div>
                        <div className = "row">
                            <label> vvar:&emsp; </label>
                            <div> { this.state.pFVArType1IEEEVArController.vvar }</div>
                        </div>
                        <div className = "row">
                            <label> vvarcbw:&emsp; </label>
                            <div> { this.state.pFVArType1IEEEVArController.vvarcbw }</div>
                        </div>
                        <div className = "row">
                            <label> vvarref:&emsp; </label>
                            <div> { this.state.pFVArType1IEEEVArController.vvarref }</div>
                        </div>
                        <div className = "row">
                            <label> vvtmax:&emsp; </label>
                            <div> { this.state.pFVArType1IEEEVArController.vvtmax }</div>
                        </div>
                        <div className = "row">
                            <label> vvtmin:&emsp; </label>
                            <div> { this.state.pFVArType1IEEEVArController.vvtmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPFVArType1IEEEVArControllerComponent
