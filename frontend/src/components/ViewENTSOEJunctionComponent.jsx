import React, { Component } from 'react'
import ENTSOEJunctionService from '../services/ENTSOEJunctionService'

class ViewENTSOEJunctionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            eNTSOEJunction: {}
        }
    }

    componentDidMount(){
        ENTSOEJunctionService.getENTSOEJunctionById(this.state.id).then( res => {
            this.setState({eNTSOEJunction: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ENTSOEJunction Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewENTSOEJunctionComponent
