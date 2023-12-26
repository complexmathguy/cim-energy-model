import React, { Component } from 'react'
import DynamicsFunctionBlockService from '../services/DynamicsFunctionBlockService';

class UpdateDynamicsFunctionBlockComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                enabled: ''
        }
        this.updateDynamicsFunctionBlock = this.updateDynamicsFunctionBlock.bind(this);

        this.changeenabledHandler = this.changeenabledHandler.bind(this);
    }

    componentDidMount(){
        DynamicsFunctionBlockService.getDynamicsFunctionBlockById(this.state.id).then( (res) =>{
            let dynamicsFunctionBlock = res.data;
            this.setState({
                enabled: dynamicsFunctionBlock.enabled
            });
        });
    }

    updateDynamicsFunctionBlock = (e) => {
        e.preventDefault();
        let dynamicsFunctionBlock = {
            dynamicsFunctionBlockId: this.state.id,
            enabled: this.state.enabled
        };
        console.log('dynamicsFunctionBlock => ' + JSON.stringify(dynamicsFunctionBlock));
        console.log('id => ' + JSON.stringify(this.state.id));
        DynamicsFunctionBlockService.updateDynamicsFunctionBlock(dynamicsFunctionBlock).then( res => {
            this.props.history.push('/dynamicsFunctionBlocks');
        });
    }

    changeenabledHandler= (event) => {
        this.setState({enabled: event.target.value});
    }

    cancel(){
        this.props.history.push('/dynamicsFunctionBlocks');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DynamicsFunctionBlock</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> enabled: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDynamicsFunctionBlock}>Save</button>
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

export default UpdateDynamicsFunctionBlockComponent
