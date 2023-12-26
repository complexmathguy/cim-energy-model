import React, { Component } from 'react'
import TopologicalNodeService from '../services/TopologicalNodeService';

class UpdateTopologicalNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                boundaryPoint: '',
                fromEndIsoCode: '',
                fromEndName: '',
                fromEndNameTso: '',
                toEndIsoCode: '',
                toEndName: '',
                toEndNameTso: ''
        }
        this.updateTopologicalNode = this.updateTopologicalNode.bind(this);

        this.changeboundaryPointHandler = this.changeboundaryPointHandler.bind(this);
        this.changefromEndIsoCodeHandler = this.changefromEndIsoCodeHandler.bind(this);
        this.changefromEndNameHandler = this.changefromEndNameHandler.bind(this);
        this.changefromEndNameTsoHandler = this.changefromEndNameTsoHandler.bind(this);
        this.changetoEndIsoCodeHandler = this.changetoEndIsoCodeHandler.bind(this);
        this.changetoEndNameHandler = this.changetoEndNameHandler.bind(this);
        this.changetoEndNameTsoHandler = this.changetoEndNameTsoHandler.bind(this);
    }

    componentDidMount(){
        TopologicalNodeService.getTopologicalNodeById(this.state.id).then( (res) =>{
            let topologicalNode = res.data;
            this.setState({
                boundaryPoint: topologicalNode.boundaryPoint,
                fromEndIsoCode: topologicalNode.fromEndIsoCode,
                fromEndName: topologicalNode.fromEndName,
                fromEndNameTso: topologicalNode.fromEndNameTso,
                toEndIsoCode: topologicalNode.toEndIsoCode,
                toEndName: topologicalNode.toEndName,
                toEndNameTso: topologicalNode.toEndNameTso
            });
        });
    }

    updateTopologicalNode = (e) => {
        e.preventDefault();
        let topologicalNode = {
            topologicalNodeId: this.state.id,
            boundaryPoint: this.state.boundaryPoint,
            fromEndIsoCode: this.state.fromEndIsoCode,
            fromEndName: this.state.fromEndName,
            fromEndNameTso: this.state.fromEndNameTso,
            toEndIsoCode: this.state.toEndIsoCode,
            toEndName: this.state.toEndName,
            toEndNameTso: this.state.toEndNameTso
        };
        console.log('topologicalNode => ' + JSON.stringify(topologicalNode));
        console.log('id => ' + JSON.stringify(this.state.id));
        TopologicalNodeService.updateTopologicalNode(topologicalNode).then( res => {
            this.props.history.push('/topologicalNodes');
        });
    }

    changeboundaryPointHandler= (event) => {
        this.setState({boundaryPoint: event.target.value});
    }
    changefromEndIsoCodeHandler= (event) => {
        this.setState({fromEndIsoCode: event.target.value});
    }
    changefromEndNameHandler= (event) => {
        this.setState({fromEndName: event.target.value});
    }
    changefromEndNameTsoHandler= (event) => {
        this.setState({fromEndNameTso: event.target.value});
    }
    changetoEndIsoCodeHandler= (event) => {
        this.setState({toEndIsoCode: event.target.value});
    }
    changetoEndNameHandler= (event) => {
        this.setState({toEndName: event.target.value});
    }
    changetoEndNameTsoHandler= (event) => {
        this.setState({toEndNameTso: event.target.value});
    }

    cancel(){
        this.props.history.push('/topologicalNodes');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TopologicalNode</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> boundaryPoint: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fromEndIsoCode: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fromEndName: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fromEndNameTso: </label>
                                            #formFields( $attribute, 'update')
                                            <label> toEndIsoCode: </label>
                                            #formFields( $attribute, 'update')
                                            <label> toEndName: </label>
                                            #formFields( $attribute, 'update')
                                            <label> toEndNameTso: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTopologicalNode}>Save</button>
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

export default UpdateTopologicalNodeComponent
