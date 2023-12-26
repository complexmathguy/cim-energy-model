import React, { Component } from 'react'
import WindType1or2UserDefinedService from '../services/WindType1or2UserDefinedService'

class ViewWindType1or2UserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windType1or2UserDefined: {}
        }
    }

    componentDidMount(){
        WindType1or2UserDefinedService.getWindType1or2UserDefinedById(this.state.id).then( res => {
            this.setState({windType1or2UserDefined: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindType1or2UserDefined Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> proprietary:&emsp; </label>
                            <div> { this.state.windType1or2UserDefined.proprietary }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindType1or2UserDefinedComponent
