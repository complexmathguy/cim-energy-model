import React, { Component } from 'react'
import CurveService from '../services/CurveService'

class ViewCurveComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            curve: {}
        }
    }

    componentDidMount(){
        CurveService.getCurveById(this.state.id).then( res => {
            this.setState({curve: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Curve Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> curveStyle:&emsp; </label>
                            <div> { this.state.curve.curveStyle }</div>
                        </div>
                        <div className = "row">
                            <label> xUnit:&emsp; </label>
                            <div> { this.state.curve.xUnit }</div>
                        </div>
                        <div className = "row">
                            <label> y1Unit:&emsp; </label>
                            <div> { this.state.curve.y1Unit }</div>
                        </div>
                        <div className = "row">
                            <label> y2Unit:&emsp; </label>
                            <div> { this.state.curve.y2Unit }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewCurveComponent
