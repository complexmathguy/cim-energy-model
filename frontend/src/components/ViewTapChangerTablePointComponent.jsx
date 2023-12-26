import React, { Component } from 'react'
import TapChangerTablePointService from '../services/TapChangerTablePointService'

class ViewTapChangerTablePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            tapChangerTablePoint: {}
        }
    }

    componentDidMount(){
        TapChangerTablePointService.getTapChangerTablePointById(this.state.id).then( res => {
            this.setState({tapChangerTablePoint: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View TapChangerTablePoint Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> b:&emsp; </label>
                            <div> { this.state.tapChangerTablePoint.b }</div>
                        </div>
                        <div className = "row">
                            <label> g:&emsp; </label>
                            <div> { this.state.tapChangerTablePoint.g }</div>
                        </div>
                        <div className = "row">
                            <label> r:&emsp; </label>
                            <div> { this.state.tapChangerTablePoint.r }</div>
                        </div>
                        <div className = "row">
                            <label> ratio:&emsp; </label>
                            <div> { this.state.tapChangerTablePoint.ratio }</div>
                        </div>
                        <div className = "row">
                            <label> step:&emsp; </label>
                            <div> { this.state.tapChangerTablePoint.step }</div>
                        </div>
                        <div className = "row">
                            <label> x:&emsp; </label>
                            <div> { this.state.tapChangerTablePoint.x }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTapChangerTablePointComponent
