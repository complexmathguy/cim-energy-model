import React, { Component } from 'react'
import ExcAVR1Service from '../services/ExcAVR1Service'

class ViewExcAVR1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAVR1: {}
        }
    }

    componentDidMount(){
        ExcAVR1Service.getExcAVR1ById(this.state.id).then( res => {
            this.setState({excAVR1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAVR1 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> e1:&emsp; </label>
                            <div> { this.state.excAVR1.e1 }</div>
                        </div>
                        <div className = "row">
                            <label> e2:&emsp; </label>
                            <div> { this.state.excAVR1.e2 }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excAVR1.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.excAVR1.kf }</div>
                        </div>
                        <div className = "row">
                            <label> se1:&emsp; </label>
                            <div> { this.state.excAVR1.se1 }</div>
                        </div>
                        <div className = "row">
                            <label> se2:&emsp; </label>
                            <div> { this.state.excAVR1.se2 }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excAVR1.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excAVR1.tb }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excAVR1.te }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.excAVR1.tf }</div>
                        </div>
                        <div className = "row">
                            <label> vrmn:&emsp; </label>
                            <div> { this.state.excAVR1.vrmn }</div>
                        </div>
                        <div className = "row">
                            <label> vrmx:&emsp; </label>
                            <div> { this.state.excAVR1.vrmx }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAVR1Component
