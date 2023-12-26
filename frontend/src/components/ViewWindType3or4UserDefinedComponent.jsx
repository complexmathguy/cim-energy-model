import React, { Component } from 'react'
import WindType3or4UserDefinedService from '../services/WindType3or4UserDefinedService'

class ViewWindType3or4UserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windType3or4UserDefined: {}
        }
    }

    componentDidMount(){
        WindType3or4UserDefinedService.getWindType3or4UserDefinedById(this.state.id).then( res => {
            this.setState({windType3or4UserDefined: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindType3or4UserDefined Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> proprietary:&emsp; </label>
                            <div> { this.state.windType3or4UserDefined.proprietary }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindType3or4UserDefinedComponent
