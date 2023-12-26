import React, { Component } from 'react'
import ConnectivityNodeService from '../services/ConnectivityNodeService';

class UpdateConnectivityNodeComponent extends Component {
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
        this.updateConnectivityNode = this.updateConnectivityNode.bind(this);

        this.changeboundaryPointHandler = this.changeboundaryPointHandler.bind(this);
        this.changefromEndIsoCodeHandler = this.changefromEndIsoCodeHandler.bind(this);
        this.changefromEndNameHandler = this.changefromEndNameHandler.bind(this);
        this.changefromEndNameTsoHandler = this.changefromEndNameTsoHandler.bind(this);
        this.changetoEndIsoCodeHandler = this.changetoEndIsoCodeHandler.bind(this);
        this.changetoEndNameHandler = this.changetoEndNameHandler.bind(this);
        this.changetoEndNameTsoHandler = this.changetoEndNameTsoHandler.bind(this);
    }

    componentDidMount(){
        ConnectivityNodeService.getConnectivityNodeById(this.state.id).then( (res) =>{
            let connectivityNode = res.data;
            this.setState({
                boundaryPoint: connectivityNode.boundaryPoint,
                fromEndIsoCode: connectivityNode.fromEndIsoCode,
                fromEndName: connectivityNode.fromEndName,
                fromEndNameTso: connectivityNode.fromEndNameTso,
                toEndIsoCode: connectivityNode.toEndIsoCode,
                toEndName: connectivityNode.toEndName,
                toEndNameTso: connectivityNode.toEndNameTso
            });
        });
    }

    updateConnectivityNode = (e) => {
        e.preventDefault();
        let connectivityNode = {
            connectivityNodeId: this.state.id,
            boundaryPoint: this.state.boundaryPoint,
            fromEndIsoCode: this.state.fromEndIsoCode,
            fromEndName: this.state.fromEndName,
            fromEndNameTso: this.state.fromEndNameTso,
            toEndIsoCode: this.state.toEndIsoCode,
            toEndName: this.state.toEndName,
            toEndNameTso: this.state.toEndNameTso
        };
        console.log('connectivityNode => ' + JSON.stringify(connectivityNode));
        console.log('id => ' + JSON.stringify(this.state.id));
        ConnectivityNodeService.updateConnectivityNode(connectivityNode).then( res => {
            this.props.history.push('/connectivityNodes');
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
        this.props.history.push('/connectivityNodes');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ConnectivityNode</h3>
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
                                        <button className="btn btn-success" onClick={this.updateConnectivityNode}>Save</button>
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

export default UpdateConnectivityNodeComponent
