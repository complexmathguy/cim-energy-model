import React, { Component } from 'react'
import PFVArType1IEEEPFControllerService from '../services/PFVArType1IEEEPFControllerService'

class ViewPFVArType1IEEEPFControllerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pFVArType1IEEEPFController: {}
        }
    }

    componentDidMount(){
        PFVArType1IEEEPFControllerService.getPFVArType1IEEEPFControllerById(this.state.id).then( res => {
            this.setState({pFVArType1IEEEPFController: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PFVArType1IEEEPFController Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ovex:&emsp; </label>
                            <div> { this.state.pFVArType1IEEEPFController.ovex }</div>
                        </div>
                        <div className = "row">
                            <label> tpfc:&emsp; </label>
                            <div> { this.state.pFVArType1IEEEPFController.tpfc }</div>
                        </div>
                        <div className = "row">
                            <label> vitmin:&emsp; </label>
                            <div> { this.state.pFVArType1IEEEPFController.vitmin }</div>
                        </div>
                        <div className = "row">
                            <label> vpf:&emsp; </label>
                            <div> { this.state.pFVArType1IEEEPFController.vpf }</div>
                        </div>
                        <div className = "row">
                            <label> vpfcbw:&emsp; </label>
                            <div> { this.state.pFVArType1IEEEPFController.vpfcbw }</div>
                        </div>
                        <div className = "row">
                            <label> vpfref:&emsp; </label>
                            <div> { this.state.pFVArType1IEEEPFController.vpfref }</div>
                        </div>
                        <div className = "row">
                            <label> vvtmax:&emsp; </label>
                            <div> { this.state.pFVArType1IEEEPFController.vvtmax }</div>
                        </div>
                        <div className = "row">
                            <label> vvtmin:&emsp; </label>
                            <div> { this.state.pFVArType1IEEEPFController.vvtmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPFVArType1IEEEPFControllerComponent
