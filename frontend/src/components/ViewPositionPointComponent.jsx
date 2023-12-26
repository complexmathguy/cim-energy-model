import React, { Component } from 'react'
import PositionPointService from '../services/PositionPointService'

class ViewPositionPointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            positionPoint: {}
        }
    }

    componentDidMount(){
        PositionPointService.getPositionPointById(this.state.id).then( res => {
            this.setState({positionPoint: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PositionPoint Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> sequenceNumber:&emsp; </label>
                            <div> { this.state.positionPoint.sequenceNumber }</div>
                        </div>
                        <div className = "row">
                            <label> xPosition:&emsp; </label>
                            <div> { this.state.positionPoint.xPosition }</div>
                        </div>
                        <div className = "row">
                            <label> yPosition:&emsp; </label>
                            <div> { this.state.positionPoint.yPosition }</div>
                        </div>
                        <div className = "row">
                            <label> zPosition:&emsp; </label>
                            <div> { this.state.positionPoint.zPosition }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPositionPointComponent
