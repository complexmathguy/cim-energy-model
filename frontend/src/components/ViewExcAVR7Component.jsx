import React, { Component } from 'react'
import ExcAVR7Service from '../services/ExcAVR7Service'

class ViewExcAVR7Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAVR7: {}
        }
    }

    componentDidMount(){
        ExcAVR7Service.getExcAVR7ById(this.state.id).then( res => {
            this.setState({excAVR7: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAVR7 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> a1:&emsp; </label>
                            <div> { this.state.excAVR7.a1 }</div>
                        </div>
                        <div className = "row">
                            <label> a2:&emsp; </label>
                            <div> { this.state.excAVR7.a2 }</div>
                        </div>
                        <div className = "row">
                            <label> a3:&emsp; </label>
                            <div> { this.state.excAVR7.a3 }</div>
                        </div>
                        <div className = "row">
                            <label> a4:&emsp; </label>
                            <div> { this.state.excAVR7.a4 }</div>
                        </div>
                        <div className = "row">
                            <label> a5:&emsp; </label>
                            <div> { this.state.excAVR7.a5 }</div>
                        </div>
                        <div className = "row">
                            <label> a6:&emsp; </label>
                            <div> { this.state.excAVR7.a6 }</div>
                        </div>
                        <div className = "row">
                            <label> k1:&emsp; </label>
                            <div> { this.state.excAVR7.k1 }</div>
                        </div>
                        <div className = "row">
                            <label> k3:&emsp; </label>
                            <div> { this.state.excAVR7.k3 }</div>
                        </div>
                        <div className = "row">
                            <label> k5:&emsp; </label>
                            <div> { this.state.excAVR7.k5 }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.excAVR7.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.excAVR7.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.excAVR7.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.excAVR7.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> t5:&emsp; </label>
                            <div> { this.state.excAVR7.t5 }</div>
                        </div>
                        <div className = "row">
                            <label> t6:&emsp; </label>
                            <div> { this.state.excAVR7.t6 }</div>
                        </div>
                        <div className = "row">
                            <label> vmax1:&emsp; </label>
                            <div> { this.state.excAVR7.vmax1 }</div>
                        </div>
                        <div className = "row">
                            <label> vmax3:&emsp; </label>
                            <div> { this.state.excAVR7.vmax3 }</div>
                        </div>
                        <div className = "row">
                            <label> vmax5:&emsp; </label>
                            <div> { this.state.excAVR7.vmax5 }</div>
                        </div>
                        <div className = "row">
                            <label> vmin1:&emsp; </label>
                            <div> { this.state.excAVR7.vmin1 }</div>
                        </div>
                        <div className = "row">
                            <label> vmin3:&emsp; </label>
                            <div> { this.state.excAVR7.vmin3 }</div>
                        </div>
                        <div className = "row">
                            <label> vmin5:&emsp; </label>
                            <div> { this.state.excAVR7.vmin5 }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAVR7Component
