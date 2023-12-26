import React, { Component } from 'react'
import PetersenCoilService from '../services/PetersenCoilService'

class ViewPetersenCoilComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            petersenCoil: {}
        }
    }

    componentDidMount(){
        PetersenCoilService.getPetersenCoilById(this.state.id).then( res => {
            this.setState({petersenCoil: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PetersenCoil Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> mode:&emsp; </label>
                            <div> { this.state.petersenCoil.mode }</div>
                        </div>
                        <div className = "row">
                            <label> nominalU:&emsp; </label>
                            <div> { this.state.petersenCoil.nominalU }</div>
                        </div>
                        <div className = "row">
                            <label> offsetCurrent:&emsp; </label>
                            <div> { this.state.petersenCoil.offsetCurrent }</div>
                        </div>
                        <div className = "row">
                            <label> positionCurrent:&emsp; </label>
                            <div> { this.state.petersenCoil.positionCurrent }</div>
                        </div>
                        <div className = "row">
                            <label> xGroundMax:&emsp; </label>
                            <div> { this.state.petersenCoil.xGroundMax }</div>
                        </div>
                        <div className = "row">
                            <label> xGroundMin:&emsp; </label>
                            <div> { this.state.petersenCoil.xGroundMin }</div>
                        </div>
                        <div className = "row">
                            <label> xGroundNominal:&emsp; </label>
                            <div> { this.state.petersenCoil.xGroundNominal }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPetersenCoilComponent
