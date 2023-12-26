import React, { Component } from 'react'
import ACLineSegmentService from '../services/ACLineSegmentService'

class ViewACLineSegmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            aCLineSegment: {}
        }
    }

    componentDidMount(){
        ACLineSegmentService.getACLineSegmentById(this.state.id).then( res => {
            this.setState({aCLineSegment: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ACLineSegment Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> b0ch:&emsp; </label>
                            <div> { this.state.aCLineSegment.b0ch }</div>
                        </div>
                        <div className = "row">
                            <label> bch:&emsp; </label>
                            <div> { this.state.aCLineSegment.bch }</div>
                        </div>
                        <div className = "row">
                            <label> g0ch:&emsp; </label>
                            <div> { this.state.aCLineSegment.g0ch }</div>
                        </div>
                        <div className = "row">
                            <label> gch:&emsp; </label>
                            <div> { this.state.aCLineSegment.gch }</div>
                        </div>
                        <div className = "row">
                            <label> r:&emsp; </label>
                            <div> { this.state.aCLineSegment.r }</div>
                        </div>
                        <div className = "row">
                            <label> r0:&emsp; </label>
                            <div> { this.state.aCLineSegment.r0 }</div>
                        </div>
                        <div className = "row">
                            <label> shortCircuitEndTemperature:&emsp; </label>
                            <div> { this.state.aCLineSegment.shortCircuitEndTemperature }</div>
                        </div>
                        <div className = "row">
                            <label> x:&emsp; </label>
                            <div> { this.state.aCLineSegment.x }</div>
                        </div>
                        <div className = "row">
                            <label> x0:&emsp; </label>
                            <div> { this.state.aCLineSegment.x0 }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewACLineSegmentComponent
