import React, { Component } from 'react'
import ExcAVR5Service from '../services/ExcAVR5Service'

class ViewExcAVR5Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAVR5: {}
        }
    }

    componentDidMount(){
        ExcAVR5Service.getExcAVR5ById(this.state.id).then( res => {
            this.setState({excAVR5: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAVR5 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excAVR5.ka }</div>
                        </div>
                        <div className = "row">
                            <label> rex:&emsp; </label>
                            <div> { this.state.excAVR5.rex }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excAVR5.ta }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAVR5Component
