import React, { Component } from 'react'
import CoordinateSystemService from '../services/CoordinateSystemService'

class ViewCoordinateSystemComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            coordinateSystem: {}
        }
    }

    componentDidMount(){
        CoordinateSystemService.getCoordinateSystemById(this.state.id).then( res => {
            this.setState({coordinateSystem: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View CoordinateSystem Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> crsUrn:&emsp; </label>
                            <div> { this.state.coordinateSystem.crsUrn }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewCoordinateSystemComponent
