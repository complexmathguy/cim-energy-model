import React, { Component } from 'react'
import ConnectivityNodeService from '../services/ConnectivityNodeService';

class CreateConnectivityNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                boundaryPoint: '',
                fromEndIsoCode: '',
                fromEndName: '',
                fromEndNameTso: '',
                toEndIsoCode: '',
                toEndName: '',
                toEndNameTso: ''
        }
        this.changeboundaryPointHandler = this.changeboundaryPointHandler.bind(this);
        this.changefromEndIsoCodeHandler = this.changefromEndIsoCodeHandler.bind(this);
        this.changefromEndNameHandler = this.changefromEndNameHandler.bind(this);
        this.changefromEndNameTsoHandler = this.changefromEndNameTsoHandler.bind(this);
        this.changetoEndIsoCodeHandler = this.changetoEndIsoCodeHandler.bind(this);
        this.changetoEndNameHandler = this.changetoEndNameHandler.bind(this);
        this.changetoEndNameTsoHandler = this.changetoEndNameTsoHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
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
    }
    saveOrUpdateConnectivityNode = (e) => {
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

        // step 5
        if(this.state.id === '_add'){
            connectivityNode.connectivityNodeId=''
            ConnectivityNodeService.createConnectivityNode(connectivityNode).then(res =>{
                this.props.history.push('/connectivityNodes');
            });
        }else{
            ConnectivityNodeService.updateConnectivityNode(connectivityNode).then( res => {
                this.props.history.push('/connectivityNodes');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ConnectivityNode</h3>
        }else{
            return <h3 className="text-center">Update ConnectivityNode</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> boundaryPoint: </label>
                                            #formFields( $attribute, 'create')
                                            <label> fromEndIsoCode: </label>
                                            #formFields( $attribute, 'create')
                                            <label> fromEndName: </label>
                                            #formFields( $attribute, 'create')
                                            <label> fromEndNameTso: </label>
                                            #formFields( $attribute, 'create')
                                            <label> toEndIsoCode: </label>
                                            #formFields( $attribute, 'create')
                                            <label> toEndName: </label>
                                            #formFields( $attribute, 'create')
                                            <label> toEndNameTso: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateConnectivityNode}>Save</button>
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

export default CreateConnectivityNodeComponent
