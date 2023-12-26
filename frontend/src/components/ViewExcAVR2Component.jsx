import React, { Component } from 'react'
import ExcAVR2Service from '../services/ExcAVR2Service'

class ViewExcAVR2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAVR2: {}
        }
    }

    componentDidMount(){
        ExcAVR2Service.getExcAVR2ById(this.state.id).then( res => {
            this.setState({excAVR2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAVR2 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> e1:&emsp; </label>
                            <div> { this.state.excAVR2.e1 }</div>
                        </div>
                        <div className = "row">
                            <label> e2:&emsp; </label>
                            <div> { this.state.excAVR2.e2 }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excAVR2.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.excAVR2.kf }</div>
                        </div>
                        <div className = "row">
                            <label> se1:&emsp; </label>
                            <div> { this.state.excAVR2.se1 }</div>
                        </div>
                        <div className = "row">
                            <label> se2:&emsp; </label>
                            <div> { this.state.excAVR2.se2 }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excAVR2.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excAVR2.tb }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excAVR2.te }</div>
                        </div>
                        <div className = "row">
                            <label> tf1:&emsp; </label>
                            <div> { this.state.excAVR2.tf1 }</div>
                        </div>
                        <div className = "row">
                            <label> tf2:&emsp; </label>
                            <div> { this.state.excAVR2.tf2 }</div>
                        </div>
                        <div className = "row">
                            <label> vrmn:&emsp; </label>
                            <div> { this.state.excAVR2.vrmn }</div>
                        </div>
                        <div className = "row">
                            <label> vrmx:&emsp; </label>
                            <div> { this.state.excAVR2.vrmx }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAVR2Component
