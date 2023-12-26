import React, { Component } from 'react'
import ExcAVR3Service from '../services/ExcAVR3Service'

class ViewExcAVR3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAVR3: {}
        }
    }

    componentDidMount(){
        ExcAVR3Service.getExcAVR3ById(this.state.id).then( res => {
            this.setState({excAVR3: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAVR3 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> e1:&emsp; </label>
                            <div> { this.state.excAVR3.e1 }</div>
                        </div>
                        <div className = "row">
                            <label> e2:&emsp; </label>
                            <div> { this.state.excAVR3.e2 }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excAVR3.ka }</div>
                        </div>
                        <div className = "row">
                            <label> se1:&emsp; </label>
                            <div> { this.state.excAVR3.se1 }</div>
                        </div>
                        <div className = "row">
                            <label> se2:&emsp; </label>
                            <div> { this.state.excAVR3.se2 }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.excAVR3.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.excAVR3.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.excAVR3.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.excAVR3.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excAVR3.te }</div>
                        </div>
                        <div className = "row">
                            <label> vrmn:&emsp; </label>
                            <div> { this.state.excAVR3.vrmn }</div>
                        </div>
                        <div className = "row">
                            <label> vrmx:&emsp; </label>
                            <div> { this.state.excAVR3.vrmx }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAVR3Component
