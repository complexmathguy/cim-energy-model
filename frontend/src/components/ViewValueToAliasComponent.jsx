import React, { Component } from 'react'
import ValueToAliasService from '../services/ValueToAliasService'

class ViewValueToAliasComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            valueToAlias: {}
        }
    }

    componentDidMount(){
        ValueToAliasService.getValueToAliasById(this.state.id).then( res => {
            this.setState({valueToAlias: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ValueToAlias Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.valueToAlias.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewValueToAliasComponent
