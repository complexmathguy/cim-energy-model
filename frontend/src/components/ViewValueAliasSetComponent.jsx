import React, { Component } from 'react'
import ValueAliasSetService from '../services/ValueAliasSetService'

class ViewValueAliasSetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            valueAliasSet: {}
        }
    }

    componentDidMount(){
        ValueAliasSetService.getValueAliasSetById(this.state.id).then( res => {
            this.setState({valueAliasSet: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ValueAliasSet Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewValueAliasSetComponent
