import React, { Component } from 'react'
import ENTSOETopologicalNodeService from '../services/ENTSOETopologicalNodeService';

class UpdateENTSOETopologicalNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateENTSOETopologicalNode = this.updateENTSOETopologicalNode.bind(this);

    }

    componentDidMount(){
        ENTSOETopologicalNodeService.getENTSOETopologicalNodeById(this.state.id).then( (res) =>{
            let eNTSOETopologicalNode = res.data;
            this.setState({
            });
        });
    }

    updateENTSOETopologicalNode = (e) => {
        e.preventDefault();
        let eNTSOETopologicalNode = {
            eNTSOETopologicalNodeId: this.state.id,
        };
        console.log('eNTSOETopologicalNode => ' + JSON.stringify(eNTSOETopologicalNode));
        console.log('id => ' + JSON.stringify(this.state.id));
        ENTSOETopologicalNodeService.updateENTSOETopologicalNode(eNTSOETopologicalNode).then( res => {
            this.props.history.push('/eNTSOETopologicalNodes');
        });
    }


    cancel(){
        this.props.history.push('/eNTSOETopologicalNodes');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ENTSOETopologicalNode</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateENTSOETopologicalNode}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateENTSOETopologicalNodeComponent
