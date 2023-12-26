import React, { Component } from 'react'
import DCNodeService from '../services/DCNodeService';

class UpdateDCNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDCNode = this.updateDCNode.bind(this);

    }

    componentDidMount(){
        DCNodeService.getDCNodeById(this.state.id).then( (res) =>{
            let dCNode = res.data;
            this.setState({
            });
        });
    }

    updateDCNode = (e) => {
        e.preventDefault();
        let dCNode = {
            dCNodeId: this.state.id,
        };
        console.log('dCNode => ' + JSON.stringify(dCNode));
        console.log('id => ' + JSON.stringify(this.state.id));
        DCNodeService.updateDCNode(dCNode).then( res => {
            this.props.history.push('/dCNodes');
        });
    }


    cancel(){
        this.props.history.push('/dCNodes');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DCNode</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDCNode}>Save</button>
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

export default UpdateDCNodeComponent
