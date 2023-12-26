import React, { Component } from 'react'
import RegularTimePointService from '../services/RegularTimePointService'

class ViewRegularTimePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            regularTimePoint: {}
        }
    }

    componentDidMount(){
        RegularTimePointService.getRegularTimePointById(this.state.id).then( res => {
            this.setState({regularTimePoint: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View RegularTimePoint Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> sequenceNumber:&emsp; </label>
                            <div> { this.state.regularTimePoint.sequenceNumber }</div>
                        </div>
                        <div className = "row">
                            <label> value1:&emsp; </label>
                            <div> { this.state.regularTimePoint.value1 }</div>
                        </div>
                        <div className = "row">
                            <label> value2:&emsp; </label>
                            <div> { this.state.regularTimePoint.value2 }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewRegularTimePointComponent
