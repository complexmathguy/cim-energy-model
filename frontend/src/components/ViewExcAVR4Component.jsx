import React, { Component } from 'react'
import ExcAVR4Service from '../services/ExcAVR4Service'

class ViewExcAVR4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAVR4: {}
        }
    }

    componentDidMount(){
        ExcAVR4Service.getExcAVR4ById(this.state.id).then( res => {
            this.setState({excAVR4: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAVR4 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> imul:&emsp; </label>
                            <div> { this.state.excAVR4.imul }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excAVR4.ka }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excAVR4.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kif:&emsp; </label>
                            <div> { this.state.excAVR4.kif }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.excAVR4.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t1if:&emsp; </label>
                            <div> { this.state.excAVR4.t1if }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.excAVR4.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.excAVR4.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.excAVR4.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> tif:&emsp; </label>
                            <div> { this.state.excAVR4.tif }</div>
                        </div>
                        <div className = "row">
                            <label> vfmn:&emsp; </label>
                            <div> { this.state.excAVR4.vfmn }</div>
                        </div>
                        <div className = "row">
                            <label> vfmx:&emsp; </label>
                            <div> { this.state.excAVR4.vfmx }</div>
                        </div>
                        <div className = "row">
                            <label> vrmn:&emsp; </label>
                            <div> { this.state.excAVR4.vrmn }</div>
                        </div>
                        <div className = "row">
                            <label> vrmx:&emsp; </label>
                            <div> { this.state.excAVR4.vrmx }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAVR4Component
