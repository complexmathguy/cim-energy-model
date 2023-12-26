import React, { Component } from 'react'
import DiagramService from '../services/DiagramService';

class CreateDiagramComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                orientation: '',
                x1InitialView: '',
                x2InitialView: '',
                y1InitialView: '',
                y2InitialView: ''
        }
        this.changeorientationHandler = this.changeorientationHandler.bind(this);
        this.changex1InitialViewHandler = this.changex1InitialViewHandler.bind(this);
        this.changex2InitialViewHandler = this.changex2InitialViewHandler.bind(this);
        this.changey1InitialViewHandler = this.changey1InitialViewHandler.bind(this);
        this.changey2InitialViewHandler = this.changey2InitialViewHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            DiagramService.getDiagramById(this.state.id).then( (res) =>{
                let diagram = res.data;
                this.setState({
                    orientation: diagram.orientation,
                    x1InitialView: diagram.x1InitialView,
                    x2InitialView: diagram.x2InitialView,
                    y1InitialView: diagram.y1InitialView,
                    y2InitialView: diagram.y2InitialView
                });
            });
        }        
    }
    saveOrUpdateDiagram = (e) => {
        e.preventDefault();
        let diagram = {
                diagramId: this.state.id,
                orientation: this.state.orientation,
                x1InitialView: this.state.x1InitialView,
                x2InitialView: this.state.x2InitialView,
                y1InitialView: this.state.y1InitialView,
                y2InitialView: this.state.y2InitialView
            };
        console.log('diagram => ' + JSON.stringify(diagram));

        // step 5
        if(this.state.id === '_add'){
            diagram.diagramId=''
            DiagramService.createDiagram(diagram).then(res =>{
                this.props.history.push('/diagrams');
            });
        }else{
            DiagramService.updateDiagram(diagram).then( res => {
                this.props.history.push('/diagrams');
            });
        }
    }
    
    changeorientationHandler= (event) => {
        this.setState({orientation: event.target.value});
    }
    changex1InitialViewHandler= (event) => {
        this.setState({x1InitialView: event.target.value});
    }
    changex2InitialViewHandler= (event) => {
        this.setState({x2InitialView: event.target.value});
    }
    changey1InitialViewHandler= (event) => {
        this.setState({y1InitialView: event.target.value});
    }
    changey2InitialViewHandler= (event) => {
        this.setState({y2InitialView: event.target.value});
    }

    cancel(){
        this.props.history.push('/diagrams');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Diagram</h3>
        }else{
            return <h3 className="text-center">Update Diagram</h3>
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
                                            <label> orientation: </label>
                                            #formFields( $attribute, 'create')
                                            <label> x1InitialView: </label>
                                            #formFields( $attribute, 'create')
                                            <label> x2InitialView: </label>
                                            #formFields( $attribute, 'create')
                                            <label> y1InitialView: </label>
                                            #formFields( $attribute, 'create')
                                            <label> y2InitialView: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDiagram}>Save</button>
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

export default CreateDiagramComponent
