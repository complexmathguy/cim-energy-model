import React, { Component } from 'react'
import CurveDataService from '../services/CurveDataService'

class ViewCurveDataComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            curveData: {}
        }
    }

    componentDidMount(){
        CurveDataService.getCurveDataById(this.state.id).then( res => {
            this.setState({curveData: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View CurveData Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> xvalue:&emsp; </label>
                            <div> { this.state.curveData.xvalue }</div>
                        </div>
                        <div className = "row">
                            <label> y1value:&emsp; </label>
                            <div> { this.state.curveData.y1value }</div>
                        </div>
                        <div className = "row">
                            <label> y2value:&emsp; </label>
                            <div> { this.state.curveData.y2value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewCurveDataComponent
