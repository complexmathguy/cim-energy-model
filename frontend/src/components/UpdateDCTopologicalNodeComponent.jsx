import React, { Component } from 'react'
import DCTopologicalNodeService from '../services/DCTopologicalNodeService';

class UpdateDCTopologicalNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDCTopologicalNode = this.updateDCTopologicalNode.bind(this);

    }

    componentDidMount(){
        DCTopologicalNodeService.getDCTopologicalNodeById(this.state.id).then( (res) =>{
            let dCTopologicalNode = res.data;
            this.setState({
            });
        });
    }

    updateDCTopologicalNode = (e) => {
        e.preventDefault();
        let dCTopologicalNode = {
            dCTopologicalNodeId: this.state.id,
        };
        console.log('dCTopologicalNode => ' + JSON.stringify(dCTopologicalNode));
        console.log('id => ' + JSON.stringify(this.state.id));
        DCTopologicalNodeService.updateDCTopologicalNode(dCTopologicalNode).then( res => {
            this.props.history.push('/dCTopologicalNodes');
        });
    }


    cancel(){
        this.props.history.push('/dCTopologicalNodes');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DCTopologicalNode</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDCTopologicalNode}>Save</button>
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

export default UpdateDCTopologicalNodeComponent
